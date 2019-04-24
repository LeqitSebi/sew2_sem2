package slanitsch.ue13.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LottoTipp {

    private HashSet ziffern = new HashSet();

    public static void main(String[] args) {
        LottoTipp a = new LottoTipp();
        LottoTipp b = new LottoTipp();
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println("a.countEqualNumbers(b): " + a.countEqualNumbers(b));
//        System.out.println("a.countEqualNumbers(a): 6 | " + a.countEqualNumbers(a));
//        System.out.println("a.equals(b): " + a.equals(b));
//        System.out.println("a.equals(a): true | " + a.equals(a));
//        System.out.println(createLottoTipps(6));
        printCalcGewinne(calcGewinne(2));

    }

    public LottoTipp() {
        for (int i = 0; i < 6; i++) {
            int range = (45 - 1) + 1;
            this.ziffern.add((int) (Math.random() * range) + 1);
        }
    }

    @Override
    public String toString() {
        TreeSet sort = new TreeSet();
        sort.addAll(ziffern);
        return sort + "";
    }

    public HashSet getZiffern() {
        return ziffern;
    }

    public int countEqualNumbers(LottoTipp other) {
        int counter = 0;

        String otherString[] = other.getZiffern().toString().split(",");
        String thisString[] = getZiffern().toString().split(",");

        for (int i = 0; i < otherString.length; i++) {
            for (int j = 0; j < thisString.length; j++) {
                if (otherString[i].contains(thisString[j])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public boolean equals(Object obj) {
        while (obj.toString().length() == getZiffern().toString().length()) {

            if (obj.equals(getZiffern())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode(LottoTipp other) {
        return other.hashCode();
    }

    public static Set<LottoTipp> createLottoTipps(int anzahl) {

        HashSet lottoTipps = new HashSet();

        for (int i = 0; i < anzahl; i++) {
            LottoTipp tipp = new LottoTipp();
            lottoTipps.add("\n" + tipp);
        }
        return lottoTipps;
    }

    public static int[] calcGewinne(int seconds) {
        LottoTipp rightTipp = new LottoTipp();
        int right_guesses;
        int[] output = new int[7];
        long endTime = System.currentTimeMillis() + (seconds*1000);
        while (System.currentTimeMillis() <= endTime){
                LottoTipp guess = new LottoTipp();
                right_guesses = guess.countEqualNumbers(rightTipp);
                output[right_guesses]++;
        }
        return output;
    }

    public static void printCalcGewinne(int[]gewinne){
        System.out.println("Ein 0er, 1er, etc. kam insgesamt vor:");
        System.out.println("0er: " + gewinne[0]);
        System.out.println("1er: " + gewinne[1]);
        System.out.println("2er: " + gewinne[2]);
        System.out.println("3er: " + gewinne[3]);
        System.out.println("4er: " + gewinne[4]);
        System.out.println("5er: " + gewinne[5]);
        System.out.println("6er: " + gewinne[6]);
    }
}