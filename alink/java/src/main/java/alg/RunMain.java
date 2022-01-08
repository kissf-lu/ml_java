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

        if (name.equals("C45C")) {
            C45C c45Classification = new C45C();
            c45Classification.c45Test();
        } else if (name.equals("ID3CL")) {
            ID3CL id3CL = new ID3CL();
            id3CL.testId3();
        } else {
            System.out.println("no such name " + name + "ML func!");
        }
    }
}
