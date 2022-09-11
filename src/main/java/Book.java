import java.io.*;
import java.util.*;
abstract class Book {
        String title;
        abstract void setTitle(String s);
        String getTitle(){
            return title;
        }
}
