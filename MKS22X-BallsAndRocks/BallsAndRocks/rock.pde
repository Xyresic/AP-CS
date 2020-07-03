
FloatList loc = new FloatList(); //abbreviation for sanity

class Rock extends Thing {
  PImage image;
  PImage eyesForRock ;

  Rock(float x, float y) {

    super(x, y);
    loc.append(x + 45);
    loc.append(y + (65/2));
    image = loadImage("rock"+(int)(random(2)+1)+".png");
    image.resize(90, 65);
    eyesForRock = loadImage("eyes.png") ;
    eyesForRock.resize(25, 25) ;
  }

  void display() {
    fill(160, 160, 160);
    image(image, x, y);

    noStroke();
  }
}

public class LivingRock extends Rock implements Moveable {
  int locidx;
  float direction;
  float randX, randY;
  float dx, dy;
  float[] directions = new float[]{0.0, 0.5, 1.0, 1.5};
  int movementType;
  LivingRock(float x, float y) {
    super(x, y);
    locidx = loc.size() - 2;
    movementType = (int)random(3);
    randX = random(width);
    randY = random(height);
    if (movementType == 0) {
      direction = random(2);
    } else if (movementType == 1) {
      dx = (randX-x)/30;
      dy = (randY-y)/30;
    } else if (movementType == 2) {
      direction = directions[(int)random(4)];
    }
  }
  void display() {
    super.display();
    loc.set(locidx, x + 45);
    loc.set(locidx + 1, y + 65/2);
    image(eyesForRock, x+40, y+20) ;
    //println(loc.get(locidx), loc.get(locidx + 1), x, y, locidx);
  }
  void update() {
    dx = (float)(5*Math.cos(direction*Math.PI));
    dy = (float)(5*Math.sin(direction*Math.PI));
  }
  float[] generateDirections() {
    float[] copy = new float[3];
    int index = 0;
    for (float val : directions) {
      if (val!=direction) {
        copy[index]=val;
        index++;
      }
    }
    return copy;
  }
  void screensaver() {
    update();
    if (x+dx<0 || x+dx>width) {
      direction = 1-direction;
    } else if (y+dy<0 || y+dy>height) {
      direction = -direction;
    }
  }
  void randTarget() {
    if (dist(x, y, randX, randY)<1) {
      randX = random(width);
      randY = random(height);
      dx = (randX-x)/30;
      dy = (randY-y)/30;
    }
  }
  void randWalk() {
    if (random(10)<1) {
      direction = generateDirections()[(int)random(3)];
    }
    update();
    if (x+dx<0 || x+dx>width || y+dy<0 || y+dy>height) {
      direction = generateDirections()[(int)random(3)];
    }
    update();
  }
  void move() {
    if (movementType == 0) {
      screensaver();
    } else if (movementType == 1) {
      randTarget();
    } else if (movementType == 2) {
      randWalk();
    }
    x+=dx;
    y+=dy;
  }
}
