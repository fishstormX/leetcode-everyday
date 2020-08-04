package aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListUtil {
    public static void printArray(int n[]){
        for(int s : n){
            System.out.print(s+", ");
        }
        System.out.println();
    }
    public static void printArray(Object n[]){
        for(Object s : n){
            System.out.print(s+", ");
        }
        System.out.println();
    }
}
