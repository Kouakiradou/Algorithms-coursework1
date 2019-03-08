import java.io.IOException;

public class Test
{
    public static void main(String arg[]) throws IOException
    {
        Matching m = new Matching("view1.png", "view2.png");
        m.matchImage();
    }
}
