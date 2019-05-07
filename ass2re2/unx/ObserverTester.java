package Oop_a2.ass2.ass2re2.unx;

import java.util.ArrayList;

/**
 A class for testing an implementation of the Observer pattern.
 */
public class ObserverTester {
   /**
    Creates a DataModel and attaches barchart and textfield listeners
    @param args unused
    */
   public static void main(String[] args) {

      ArrayList<Double> data = new ArrayList<Double>();
      data.add(100.0);
      data.add(100.0);
      data.add(100.0);
      data.add(100.0);

      DataModel model = new DataModel(data);

      TextFrame frame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);

      model.attach(barFrame);
      model.attach(frame);
   }
}