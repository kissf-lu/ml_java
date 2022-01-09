package alg;

import alg.classification.C45C;
import alg.classification.ID3CL;

/**
 *
 */
public class RunMain {
    public static void main(String[] args) throws Exception {
        callMl("C45C");

    }

    public static void callMl(String name) throws Exception {
        String c45 = "C45C";
        String id3 = "ID3CL";
        if (c45.equals(name)) {
            C45C c45Classification = new C45C();
            c45Classification.c45Test();
        } else if (id3.equals(name)) {
            ID3CL id3cl = new ID3CL();
            id3cl.testId3();
        } else {
            System.out.println("no such name " + name + "ML func!");
        }
    }
}
