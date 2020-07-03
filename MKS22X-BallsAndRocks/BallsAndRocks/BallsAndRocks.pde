interface Displayable {
  void display();
}

interface Moveable {
  void move();
}

interface Collideable {
  boolean isTouching();
}

abstract class Thing implements Displayable {
  float x, y;//Position of the Thing

  Thing(float x, float y) {
    this.x = x;
    this.y = y;
  }
  abstract void display();
}

void showhitbox() {
  fill(244, 244, 66);
  for (int i = 0; i<loc.size(); i+=2) {
    ellipse(loc.get(i), loc.get(i + 1), 50, 50);
    //println(i);
  }
  //println(loc.size());
}


/*DO NOT EDIT THE REST OF THIS */

ArrayList<Displayable> thingsToDisplay;
ArrayList<Moveable> thingsToMove;

void setup() {
  size(1000, 800);

  thingsToDisplay = new ArrayList<Displayable>();
  thingsToMove = new ArrayList<Moveable>();
  for (int i = 0; i < 10; i++) {
    Rock r = new Rock(50+random(width-100), 50+random(height-100));
    thingsToDisplay.add(r);
  }
  for (int i = 0; i < 5; i ++) {
    BallTwo t = new BallTwo(50+random(width-100), 50+random(height-100));
    thingsToDisplay.add(t);
    thingsToMove.add(t);
    BallOne o = new BallOne(50+random(width-100), 50+random(height-100));
    thingsToDisplay.add(o);
    thingsToMove.add(o);
  }
  for (int i = 0; i < 3; i++) {
    LivingRock m = new LivingRock(50+random(width-100), 50+random(height-100));
    thingsToDisplay.add(m);
    thingsToMove.add(m);
  }
}
void draw() {
  //background(255);
  background(51);  

  for (Displayable thing : thingsToDisplay) {
    thing.display();
  }
  for (Moveable thing : thingsToMove) {
    thing.move();
  }
  delay(100);

 // showhitbox();
  //circle(loc.get(21), loc.get(22),70);
}
/*void mouseClicked(){
 for (Moveable thing : thingsToMove) {
 thing.move();
 }
 }*/
