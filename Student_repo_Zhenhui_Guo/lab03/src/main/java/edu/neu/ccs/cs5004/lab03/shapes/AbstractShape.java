package edu.neu.ccs.cs5004.lab03.shapes;

import edu.neu.ccs.cs5004.lab03.shapes.Point2D;

public abstract class AbstractShape implements Shape {

    protected Point2D reference;

    public AbstractShape(Point2D reference) {
      this.reference = reference;
    }

    @Override
    public double distanceFromOrigin() {
      return reference.distToOrigin();
    }


    @Override
    public int compareTo(Shape s) {
      double areaThis = this.area();
      double areaOther = s.area();

      if (areaThis < areaOther) {
        return -1;
      } else if (areaOther < areaThis) {
        return 1;
      } else {
        return 0;
      }
    }
  }
