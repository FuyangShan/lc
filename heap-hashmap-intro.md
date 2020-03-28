# Heap & HashMap

HashMap Source Code Analysis: https://www.jianshu.com/p/b40fd341711e

## 例题

* [268.Missing Number](missing-number.md)
* [179. Largest Number](largest-number.md)
* [215.Kth Smallest element in an Array](kth-largest-element-in-an-array.md)
* [378.Kth Smallest Element in a Sorted Matrix](kth-smallest-element-in-a-sorted-matrix.md)
* [347.Top K Frequent elements](top-k-frequent-elements.md)
* [451. Sort Characters by Frequency](sort-characters-by-frequency.md)
* [703. Kth Largest Element in Stream](kth-largest-element-in-a-stream.md)
* [692. Top k frequent words](top-k-frequent-words.md)
* [961. N-RepeatedElements](n-repeated-element-in-size-2n-array.md)
* [500. KeyBoardRow](keyboard-row.md)
* [609. Find Duplicate File in System](find-duplicate-file-in-system.md)
* [349. Intersection of Two Arrays](intersection-of-two-arrays.md)
* [373. Find K Pairs with Smallest Sums](find-k-pairs-with-smallest-sums.md)
* [218. The Skyline Problem](the-skyline-problem.md)
* [332. Reconstruct Itinerary](reconstruct-itinerary.md)



## HashMap 的实现原理
HashMap 是典型的空间换时间的一种技术手段。

- 如何解决 hash 冲突
- loadFactor 等核心概念
- 扩容机制

## 构造函数中 initialCapacity 与 loadFactor 两个参数
HashMap(int initialCapacity, float loadFactor)：构造一个指定容量和加载因子的空 HashMap

在这里提到了两个参数：初始容量，加载因子。这两个参数是影响 HashMap 性能的重要参数，其中容量表示哈希表中桶的数量，初始容量是创建哈希表时的容量，加载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度，它衡量的是一个散列表的空间的使用程度，负载因子越大表示散列表的装填程度越高，反之愈小。对于使用链表法的散列表来说，查找一个元素的平均时间是 O(1+a)，因此如果负载因子越大，对空间的利用更充分，然而后果是查找效率的降低；如果负载因子太小，那么散列表的数据将过于稀疏，对空间造成严重浪费。系统默认负载因子为 0.75，一般情况下我们是无需修改的。

## initialCapacity 和 loadFactor 参数设什么样的值好呢？
initialCapacity 的默认值是 16，有些人可能会想如果内存足够，是不是可以将 initialCapacity 设大一些，即使用不了这么大，就可避免扩容导致的效率的下降，反正无论 initialCapacity 大小，我们使用的 get 和 put 方法都是常数复杂度的。这么说没什么不对，但是可能会忽略一点，实际的程序可能不仅仅使用 get 和 put 方法，也有可能使用迭代器，如 initialCapacity 容量较大，那么会使迭代器效率降低。所以理想的情况还是在使用 HashMap 前估计一下数据量。

加载因子默认值是 0.75，是 JDK 权衡时间和空间效率之后得到的一个相对优良的数值。如果这个值过大，虽然空间利用率是高了，但是对于 HashMap 中的一些方法的效率就下降了，包括 get 和 put 方法，会导致每个 hash 桶所附加的链表增长，影响存取效率。如果比较小，除了导致空间利用率较低外没有什么坏处，只要有的是内存，毕竟现在大多数人把时间看的比空间重要。但是实际中还是很少有人会将这个值设置的低于 0.5。

## size 为什么必须是 2 的整数次幂
这是为了服务key映射到index的Hash算法的，公式index=hashcode(key)&(length-1)，初始长度(16-1)，二进制为1111&hashcode结果为hashcode最后四位，能最大程度保持平均，二的幂数保证二进制为1，保持hashcode最后四位。这种算法在保持分布均匀之外，效率也非常高。

## HashMap 的 key 为什么一般用字符串比较多，能用其他对象，或者自定义的对象吗？为什么？
能用其他对象，必须是immutable的，但是自实现的类必须Override两个方法：equals()和hashCode()。否则会调用默认的Object类的对应方法。

## 为什么HashMap要允许key和value都能为null呢？
解释一：首先，HashTable 是一个过时的类，不应该再使用了。
当时不允许是因为希望每个 key 都会实现 hashCode 和 equals 方法。而 null 显然没有。后来，大家都意识到 null 值的重要性，所以 HashMap 允许 null 值的 key 和 value。当 key 为 null 时，HashMap 将会把 key-value pair 存放在一个特殊的位置，比如第一个槽位里。

解释二：ConcurrentHashmap 和 Hashtable 都是支持并发的，这样会有一个问题，当你通过 get(k) 获取对应的 value 时，如果获取到的是 null 时，你无法判断，它是 put() 的时候 value 为 null，还是这个 key 从来没有做过映射。HashMap 是非并发的，可以通过 contains(key) 来做这个判断。而支持并发的 Map 在调用 m.contains（key）和 m.get(key),m 可能已经不同了。

## 为什么需要使用加载因子，为什么需要扩容呢？
因为如果填充比很大，说明利用的空间很多，如果一直不进行扩容的话，链表就会越来越长，这样查找的效率很低，因为链表的长度很大（当然最新版本使用了红黑树后会改进很多），扩容之后，将原来链表数组的每一个链表分成奇偶两个子链表分别挂在新链表数组的散列位置，这样就减少了每个链表的长度，增加查找效率。

HashMap 本来是以空间换时间，所以填充比没必要太大。但是填充比太小又会导致空间浪费。如果关注内存，填充比可以稍大，如果主要关注查找性能，填充比可以稍小。

## 使用红黑树的改进
在 java jdk8 中对 HashMap 的源码进行了优化，在 jdk7 中，HashMap 处理 “碰撞” 的时候，都是采用链表来存储，当碰撞的结点很多时，查询时间是 O(n)。
在 jdk8 中，HashMap 处理 “碰撞” 增加了红黑树这种数据结构，当碰撞结点较少时，采用链表存储，当较大时（>8 个），采用红黑树（特点是查询时间是 O(logn)）存储（有一个阀值控制，大于阀值 (8 个)，将链表存储转换成红黑树存储）

问题分析：
哈希碰撞会对 hashMap 的性能带来灾难性的影响。如果多个 hashCode() 的值落到同一个桶内的时候，这些值是存储到一个链表中的。最坏的情况下，所有的 key 都映射到同一个桶中，这样 hashmap 就退化成了一个链表——查找时间从 O(1) 到 O(n)。

随着 HashMap 的大小的增长，get() 方法的开销也越来越大。由于所有的记录都在同一个桶里的超长链表内，平均查询一条记录就需要遍历一半的列表。
JDK1.8HashMap 的红黑树是这样解决的：
如果某个桶中的记录过大的话（当前是 TREEIFY_THRESHOLD = 8），HashMap 会动态的使用一个专门的 treemap 实现来替换掉它。这样做的结果会更好，是 O(logn)，而不是糟糕的 O(n)。

它是如何工作的？前面产生冲突的那些 KEY 对应的记录只是简单的追加到一个链表后面，这些记录只能通过遍历来进行查找。但是超过这个阈值后 HashMap 开始将列表升级成一个二叉树，使用哈希值作为树的分支变量，如果两个哈希值不等，但指向同一个桶的话，较大的那个会插入到右子树里。如果哈希值相等，HashMap 希望 key 值最好是实现了 Comparable 接口的，这样它可以按照顺序来进行插入。这对 HashMap 的 key 来说并不是必须的，不过如果实现了当然最好。如果没有实现这个接口，在出现严重的哈希碰撞的时候，你就并别指望能获得性能提升了。

## HashMap 的 key 和 value 都能为 null 么？如果 key 能为 null，那么它是怎么样查找值的？
如果 key 为 null，则直接从哈希表的第一个位置 table[0] 对应的链表上查找,由 putForNullKey（）实现。记住，key 为 null 的键值对永远都放在以 table[0] 为头结点的链表中。

## 平时在使用 HashMap 时一般使用什么类型的元素作为 Key？
面试者通常会回答，使用 String 或者 Integer 这样的类。这个时候可以继续追问为什么使用 String、Integer 呢？这些类有什么特点？如果面试者有很好的思考，可以回答出这些类是 Immutable 的，并且这些类已经很规范的覆写了 hashCode() 以及 equals() 方法。作为不可变类天生是线程安全的，而且可以很好的优化比如可以缓存 hash 值，避免重复计算等等，那么基本上这道题算是过关了。

在 HashMap 中使用可变对象作为 Key 带来的问题：如果 HashMap Key 的哈希值在存储键值对后发生改变，Map 可能再也查找不到这个 Entry 了。详见：一道面试题看 HashMap 的存储方式

## Key对应的hashCode()方法
对于非 String 类型的 key，hash() 使用 key 的 hashCode() 计算出该 key-value pair 对应在数组的索引 (String 类型的 key 有另一套计算 hash() 的方法，再次不做赘述），在 get() 方法中会使用 key 的 equal() 方法判断数组中的中的 key 是否与传入的 key 相等。由此可见，在 HashMap 的使用中，key 类型中定义的 hashCode() 和 equal() 方法都是非常重要的。假设 key 内部的值发生变化，导致 hashCode()/equal() 的结果改变，那么该 key 在 HashMap 中的存取则会产生问题。

## 如何创建不可变类(Immutable)/如果让你实现一个自定义的 class 作为 HashMap 的 key 该如何实现？

Immutable Objects 就是那些一旦被创建，它们的状态就不能被改变的 Objects，每次对他们的改变都是产生了新的 immutable 的对象，而 mutable Objects 就是那些创建后，状态可以被改变的 Objects。
举个例子：String 是 immutable 的，每次对于 String 对象的修改都将产生一个新的 String 对象，而原来的对象保持不变。而 StringBuilder 是 mutable，因为每次对于它的对象的修改都作用于该对象本身，并没有产生新的对象。
但有的时候 String 的 immutable 特性也会引起安全问题，这就是密码应该存放在字符数组中而不是 String 中的原因！

要写出这样的类，需要遵循以下几个原则：

immutable 对象的状态在创建之后就不能发生改变，任何对它的改变都应该产生一个新的对象。
Immutable 类的所有的属性都应该是 final 的。
对象必须被正确的创建，比如：对象引用在对象创建过程中不能泄露 (leak)。
对象应该是 final 的，以此来限制子类继承父类，以避免子类改变了父类的 immutable 特性。
如果类中包含 mutable 类对象，那么返回给客户端的时候，返回该对象的一个拷贝，而不是该对象本身（该条可以归为第一条中的一个特例）

```java
public class MutableKey {
    private int i;
    private int j;

    public MutableKey(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public final int getI() {
        return i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final int getJ() {
        return j;
    }

    public final void setJ(int j) {
        this.j = j;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + j;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableKey)) {
            return false;
        }
        MutableKey other = (MutableKey) obj;
        if (i != other.i) {
            return false;
        }
        if (j != other.j) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Object created
        MutableKey key = new MutableKey(10, 20);
        System.out.println("Hash code: " + key.hashCode());

        // Object State is changed after object creation.
        key.setI(30);
        key.setJ(40);
        System.out.println("Hash code: " + key.hashCode());
    }
}
public class MutableSafeKey {
    // Cannot be changed once object is created. No setter for this field.
    private final int id;
    private String name;

    public MutableSafeKey(final int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // Hash code depends only on 'id' which cannot be
    // changed once object is created. So hash code will not change
    // on object's state change
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MutableSafeKey other = (MutableSafeKey) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
```

## 你能设计一个算法（输入是 java 源文件），判断一个类是否是 Immutable 的吗？

## 如何衡量一个 hash 算法的好坏
hashCode 不要求唯一但是要尽可能的均匀分布，而且算法效率要尽可能的快。

## HashMap 中 hash 函数怎么是是实现的？
int i = hash & (n - 1)

## 拓展：为什么 h = 31 * h + val[off++]; 这一行使用31 ，而不是别的数字，这是一个魔术吗？

## HashMap 怎样解决哈希冲突，讲一下扩容过程。
JDK 使用了链地址法，hash 表的每个元素又分别链接着一个单链表，元素为头结点，如果不同的 key 映射到了相同的下标，那么就使用头插法，插入到该元素对应的链表。

扩容过程：

将新节点加到链表后
容量扩充为原来的两倍，然后对每个节点重新计算哈希值。
这个值只可能在两个地方，一个是原下标的位置，另一种是在下标为 <原下标 + 原容量> 的位置。
哈希冲突的常见解决方法：

开放定址法（线性探测再散列，二次探测再散列，伪随机探测再散列）
再哈希法，就是在原 hash 函数的基础，再次执行 hash 算法
链地址法，各种处理哈希碰撞的方法中，这种最简单，也是 HashMap 中使用的方法
建立一个公共溢出区

## failure case/resize()
Load factor(default to 75%) 和 Initial capacity(default to 16) 是 HashMap 表的两个重要属性，如果 HashMap 中 entry 数量超过了 threshold(loadfactor *capacity) ，那么 HashMap 就不得不扩充 capacity（否则 hash collison 发生的概率就会大大增加，导致整个 HashMap 性能下降），扩充 capacity 是一件比较麻烦的事情，因为数组的连续性，HashMap 不得不开辟一块更大数组，还要把原来的 entries 全部 transfer 到新的数组中，在某些情况下还需要重新计算 key 的 hash() 结果。另一方面，HashMap 的 capacity 也不是越大越好，事实上 HashMap 的遍历本质上是基于内部数组的遍历，如果内部数组是无意义的大，那么遍历 HashMap 相对来说不是特别高效。

## 为什么 HashMap 是线程不安全的，实际会如何体现？
第一，如果多个线程同时使用 put 方法添加元素
假设正好存在两个 put 的 key 发生了碰撞 (hash 值一样)，那么根据 HashMap 的实现，这两个 key 会添加到数组的同一个位置，这样最终就会发生其中一个线程的 put 的数据被覆盖。

第二，如果多个线程同时检测到元素个数超过数组大小 * loadFactor
这样会发生多个线程同时对 hash 数组进行扩容，都在重新计算元素位置以及复制数据，但是最终只有一个线程扩容后的数组会赋给 table，也就是说其他线程的都会丢失，并且各自线程 put 的数据也丢失。且会引起死循环的错误。

具体细节上的原因，可以参考：不正当使用 HashMap 导致 cpu 100% 的问题追究

## HashMap 不是线程安全的，你怎么理解线程安全。原理是什么？几种方式避免线程安全的问题
如何线程安全的使用 HashMap

直接使用 Hashtable，但是当一个线程访问 HashTable 的同步方法时，其他线程如果也要访问同步方法，会被阻塞住。举个例子，当一个线程使用 put 方法时，另一个线程不但不可以使用 put 方法，连 get 方法都不可以，效率很低，现在基本不会选择它了。
HashMap 可以通过下面的语句进行同步：
Collections.synchronizeMap(hashMap);
直接使用 JDK 5 之后的 ConcurrentHashMap。

## HashTable 和 HashMap 的区别有哪些？
HashMap 和 Hashtable 都实现了 Map 接口，但决定用哪一个之前先要弄清楚它们之间的分别。主要的区别有：线程安全性，同步 (synchronization)，以及速度。

理解 HashMap 是 Hashtable 的轻量级实现（非线程安全的实现，hashtable 是非轻量级，线程安全的），都实现 Map 接口，主要区别在于：

1. 由于 HashMap 非线程安全，在只有一个线程访问的情况下，效率要高于 HashTable
2. HashMap 允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。
3. HashMap 把 Hashtable 的 contains 方法去掉了，改成 containsValue 和 containsKey。因为 contains 方法容易让人引起误解。
4. Hashtable 继承自陈旧的 Dictionary 类，而 HashMap 是 Java1.2 引进的 Map 的一个实现。
5. Hashtable 和 HashMap 扩容的方法不一样，HashTable 中 hash 数组默认大小 11，扩容方式是 old*2+1。HashMap 中 hash 数组的默认大小是 16，而且一定是 2 的指数，增加为原来的 2 倍，没有加 1。
6. 两者通过 hash 值散列到 hash 表的算法不一样，HashTbale 是古老的除留余数法，直接使用 hashcode，而后者是强制容量为 2 的幂，重新根据 hashcode 计算 hash 值，在使用 hash 位与 （hash 表长度 – 1），也等价取膜，但更加高效，取得的位置更加分散，偶数，奇数保证了都会分散到。前者就不能保证。
7. 另一个区别是 HashMap 的迭代器 (Iterator) 是 fail-fast 迭代器，而 Hashtable 的 enumerator 迭代器不是 fail-fast 的。所以当有其它线程改变了 HashMap 的结构（增加或者移除元素），将会抛出 ConcurrentModificationException，但迭代器本身的 remove() 方法移除元素则不会抛出 ConcurrentModificationException 异常。但这并不是一个一定发生的行为，要看 JVM。这条同样也是 Enumeration 和 Iterator 的区别。
fail-fast 和 iterator 迭代器相关。如果某个集合对象创建了 Iterator 或者 ListIterator，然后其它的线程试图 “结构上” 更改集合对象，将会抛出 ConcurrentModificationException 异常。但其它线程可以通过 set() 方法更改集合对象是允许的，因为这并没有从 “结构上” 更改集合。但是假如已经从结构上进行了更改，再调用 set() 方法，将会抛出 IllegalArgumentException 异常。
结构上的更改指的是删除或者插入一个元素，这样会影响到 map 的结构。
该条说白了就是在使用迭代器的过程中有其他线程在结构上修改了 map，那么将抛出 ConcurrentModificationException，这就是所谓 fail-fast 策略。
引申扩展：建议用 ConcurrentHashMap 代替 Hashtable。

## 为什么 HashTable 的默认大小和 HashMap 不一样？
前面分析了，Hashtable 的扩容方法是乘 2 再 + 1，不是简单的乘 2，故 hashtable 保证了容量永远是奇数，结合之前分析 hashmap 的重算 hash 值的逻辑，就明白了，因为在数据分布在等差数据集合 (如偶数) 上时，如果公差与桶容量有公约数 n，则至少有 (n-1)/n 数量的桶是利用不到的，故之前的 hashmap 会在取模（使用位与运算代替）哈希前先做一次哈希运算，调整 hash 值。这里 hashtable 比较古老，直接使用了除留余数法，那么就需要设置容量起码不是偶数（除（近似）质数求余的分散效果好）。而 JDK 开发者选了 11。


