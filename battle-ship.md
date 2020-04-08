# Battle Ship

Jack plays a game of battleships with his friend Stacy. The game is played on a square map of N
rows, numbered from 1 to N. Each row contains N cells, labeled with consecutive English upper-case
letters (A, B, C, etc.). Each cell is identified by a string composed of its row number followed by its
column number: for example, "9C" denotes the third cell in the 9th row, and "15D" denotes the
fourth cell in the 15th row.
Jack marks the positions of all his ships on the map (which is not shown to Stacy). Ships are defined
by rectangles with a maximum area of 4 cells. Stacy picks map cells to hit some ships. A ship is
considered to be hit if at least one of its constituent cells is hit. If all of a ship's cells are hit, the ship is
sunk.
The goal is to count the number of sunk ships and the number of ships that have been hit but not
sunk.
For example, the picture below shows a map of size N = 4 with two blue ships and five hits marked
with the letter 'X':

Write a function:

class Solution { public String solution(int N, String S, String T); }

that, given the size of the map N and two strings S, T that describe the positions of ships and hits
respectively, returns a string with two numbers: the count of sunken ships and the count of ships that
have been hit but not sunk, separated with a comma.


```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String S = "1A 2A,12A 12A"; 
        String T = "12A";
        System.out.println(battleShip(S, T, 12)[0]);
        System.out.println(battleShip(S, T, 12)[1]);
    }
    public static int[] battleShip(String s, String t, int n) {
        // use set to store location of one battle ship
        List<Set<String>> list = new ArrayList<>();
        // use nList to store the size of each battleship
        List<Integer> nList = new ArrayList<>();
        // "1B 2C,2D 4D"
        String[] ships = s.split(","); // "1B 2C", "2D 4D"
        for (String ship : ships) {
            String[] cells = ship.split(" "); //[1B, 2C]
            String LT = cells[0];
            String RT = cells[1];
            int i = 0, j = 0;
            while (i < LT.length() && Character.isDigit(LT.charAt(i))) {
                i++;
            }
            while (j < RT.length() && Character.isDigit(RT.charAt(j))) {
                j++;
            }
            int L_row = Integer.parseInt(LT.substring(0, i));
            int R_row = Integer.parseInt(RT.substring(0, j));
            char L_col = LT.charAt(i);
            char R_col = RT.charAt(j);
            
            Set<String> ship_str = new HashSet<>(); // 1B,2C
            for (int row = L_row; row <= R_row; row++) {
                for (char col = L_col; col <= R_col; col++) {
                    ship_str.add(row + "" + col);
                }
            }
            list.add(ship_str);
            nList.add(ship_str.size());
        }
        int count_sunk = 0;
        int count_hit = 0;
        
        for (String str : t.split(" ")) {
            for (Set<String> set : list) {
                set.remove(str);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 0) count_sunk++;
            else if (list.get(i).size() < nList.get(i)) count_hit++;
        }
        return new int[]{count_sunk, count_hit};
    }
}
```