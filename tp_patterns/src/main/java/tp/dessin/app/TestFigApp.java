package tp.dessin.app;

import tp.dessin.ext.console.ConsoleVisitor;
import tp.dessin.ext.svg.SvgGenerateVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Figure;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestFigApp {

    public static void main(String[] args) {

        List<Figure> listeFigures =  new ArrayList<Figure>();


        Cercle cercle1 = new Cercle(100, 120, 30);
        cercle1.setCouleur("red");
        Rectangle rectangle1 = new Rectangle(150, 50, 65, 40);
        rectangle1.setCouleur("blue");
        Ligne ligne1 = new Ligne(130, 40, 180, 180);
        ligne1.setCouleur("green");

        listeFigures.add(cercle1); listeFigures.add(rectangle1); listeFigures.add(ligne1);
        ConsoleVisitor consoleVisitor = new ConsoleVisitor();
        for(Figure fig : listeFigures)
            fig.performVisit(consoleVisitor);

        exporterSvg(listeFigures);
    }

    public static void exporterSvg(List<Figure>  listeFigures){
        try {
            //String defaultFileName="c:\\temp\\figures.svg";
            String defaultFileName="figures.svg"; //+refresh eclipse ou ...
            FileOutputStream of = new FileOutputStream(defaultFileName);
            PrintStream ps = new PrintStream(of);
            ps.println("<svg xmlns='http://www.w3.org/2000/svg' width='600' height='400'>");

            SvgGenerateVisitor svgGenerateVisitor = new SvgGenerateVisitor();
            for(Figure f : listeFigures){
                //ps.println(f.toSvgString()); //ancienne version sans visiteur
                f.performVisit(svgGenerateVisitor);
            }
            ps.println(svgGenerateVisitor.getSvgContent());
            ps.println("</svg>");
            ps.close(); of.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
