class Ball extends Thing implements Moveable, Collideable {
  Ball(float x, float y) {

    super(x, y);
  }
  int col1 = int(random(255));
  int col2 = int(random(255));
  int col3 = int(random(255));


  int xspeed = int(random(60) - 30);
  int yspeed = int(random(60) - 30);
  void display() {

    /* ONE PERSON WRITE THIS */
    //fill(col1, col2, col3) ; // color
    if (isTouching()) {
      // it's near a rock or it touched it so let's make it bounce off
      fill(255, 0, 0);
      ellipse(x, y, 50, 50) ; // creation of ball
      fill(col1, col2, col3) ;
      ellipse(x, y, 25, 25) ; // smaller ball inside sort of like decoration
      fill(0, 0, 0) ;
      rect(x, y, 5, 5) ;
      xspeed = int(random(50) - 40);
      yspeed = int(random(10) - 2) ;
    } else {
      fill(255, 255, 255) ;
      ellipse(x, y, 50, 50) ; // creation of ball
      fill(0, 126, 255) ;
      ellipse(x, y, 25, 25) ; // smaller ball inside sort of like decoration
      fill(0, 0, 0) ;
      rect(x, y, 5, 5) ;
    }
  }

  boolean isTouching() {
    int i = 0;
    while (i < loc.size() /2) {
      if (dist(x, y, loc.get(i * 2), loc.get((i * 2) + 1)) < 70) {
        return(true);
      }
      i += 1;
    }
    return(false);
  }

  void hitwall() {
    if (x < 0) {
      x = 0;
      xspeed = -xspeed;
      yspeed = (int(random(60)) - 30);
    }
    if (x > width) {
      x = 1000;
      xspeed = -xspeed;
      yspeed = (int(random(60)) - 30);
    }
    if (y < 0) {
      y = 0;
      yspeed = -yspeed;
      xspeed = (int(random(60)) - 30);
    }
    if (y > height) {
      y = 800;
      yspeed = -yspeed;
      xspeed = (int(random(60)) - 30);
    }
  }

  void bounce() {
  }
  void move() {
    /* ONE PERSON WRITE THIS */
    x = x + xspeed;
    y = y + yspeed;
    // println(x,y,xspeed, yspeed);
    hitwall();
  }
}
class BallOne extends Ball { // turns red on collsion and gets slower
  BallOne(float x, float y) {
    super(x, y);
  }
  int acceleration = 5;
  void display() {

    /* ONE PERSON WRITE THIS */
    //fill(col1, col2, col3) ; // color
    if (isTouching()) {
      // it's near a rock or it touched it so let's make it bounce off
      fill(244, 67, 54);
      ellipse(x, y, 50, 50) ; // creation of ball
      fill(33, 33, 33);
      ellipse(x, y, 15, 15) ; // smaller ball inside sort of like decoration
      ellipse(x, y ,31, 31);
      fill(244, 67, 54);
      ellipse(x, y ,28, 28);
      fill(33, 33, 33);
      ellipse(x, y -15, 8, 8) ;
      ellipse(x -13, y + 7, 8, 8) ;
      ellipse(x +13, y + 7, 8, 8) ;
      ellipse(x, y, 10, 10) ;
      xspeed = int(random(50) - 40);
      yspeed = int(random(10) - 2) ;
    } else {
      fill(255, 255, 255) ;
      ellipse(x, y, 50, 50) ; // creation of ball
      fill(0, 126, 255) ;
      ellipse(x, y, 25, 25) ; // smaller ball inside sort of like decoration
      fill(0, 0, 0) ;
      rect(x, y, 5, 5) ;
    }
  }
}
class BallTwo extends Ball { // turns red on collsion and gets slower
  BallTwo(float x, float y) {
    super(x, y);
  }
  int acceleration = 5;
  void display() {

    /* ONE PERSON WRITE THIS */
    //fill(col1, col2, col3) ; // color
    if (isTouching()) {
      // it's near a rock or it touched it so let's make it bounce off
      fill(186, 104, 200);
      ellipse(x, y, 50, 50); // creation of ball
      fill(33,33,33);
      ellipse(x, y, 45, 45);
      fill(186, 104, 200);
      ellipse(x, y, 42, 42);
      
      fill(33,33,33);
      ellipse(x, y, 34, 34);
      fill(186, 104, 200);
      ellipse(x, y, 32, 32);
      
      fill(33,33,33);
      ellipse(x, y, 24, 24);
      fill(186, 104, 200);
      ellipse(x, y, 22, 22);
      
      
      fill(225, 190, 231);
      ellipse(x, y, 21, 21);
      
      fill(33,33,33);
      ellipse(x, y, 8, 8);
      ellipse(x, y - 11, 6, 6);
      ellipse(x - 12, y - 11, 6, 6);
      ellipse(x + 12, y - 11, 6, 6);
      ellipse(x + 10, y + 5, 6, 6);
      ellipse(x - 10, y + 5, 6, 6);
      ellipse(x, y + 15, 6, 6);
      xspeed = int(random(50) - 40);
      yspeed = int(random(10) - 2) ;
    } else {
      fill(255, 255, 255) ;
      ellipse(x, y, 50, 50) ; // creation of ball
      fill(0, 126, 255) ;
      ellipse(x, y, 25, 25) ; // smaller ball inside sort of like decoration
      fill(0, 0, 0) ;
      rect(x, y, 5, 5) ;
    }
  }
}
