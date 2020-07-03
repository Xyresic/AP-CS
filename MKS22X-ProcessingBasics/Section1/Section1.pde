int MAX_VALUE = 100;
int MIN_VALUE = -100;
Visualizer v;
class Visualizer {
  float x, y, boxHeight, boxWidth;
  float [] values;
  float [] speeds;
  Visualizer(float x, float y) {
    this.x = x;
    this.y = y;
    this.boxHeight = 200;
    this.boxWidth = 400;
    values = new float[10];
    speeds = new float[10];
    for (int i = 0; i < values.length; i++) {
      values[i] = random(-99, 99);
      speeds[i] = random(2);
    }
  }
  Visualizer(float x, float y, int boxes) {
    this.x = x;
    this.y = y;
    this.boxHeight = 200;
    this.boxWidth = 400;
    values = new float[boxes];
    speeds = new float[boxes];
    for (int i = 0; i < values.length; i++) {
      values[i] = random(-99, 99);
      speeds[i] = random(2);
    }
  }
  Visualizer(float x, float y, int boxes, float boxHeight, float boxWidth) {
    this.x = x;
    this.y = y;
    this.boxHeight = boxHeight;
    this.boxWidth = boxWidth;
    values = new float[boxes];
    speeds = new float[boxes];
    for (int i = 0; i < values.length; i++) {
      values[i] = random(-99, 99);
      speeds[i] = random(2);
    }
  }
  void display() {
    fill(255);
    rect(x, y, boxWidth, boxHeight);
    line(x, y+boxHeight/2, x+boxWidth, y+boxHeight/2);
    float eachWidth = boxWidth/values.length;
    for (int i = 0; i<values.length; i++) {
      float r = values[i]<0? 255:255*(1-2*values[i]/boxHeight);
      float g = values[i]>0? 255:255*(1+2*values[i]/boxHeight);
      fill(r, g, 0);
      rect(x+i*eachWidth, y+boxHeight/2-values[i], eachWidth, values[i]);
    }
  }
  void update() {
    for (int i = 0; i < values.length; i++) {
      values[i] += speeds[i];
      if (values[i]>boxHeight/2-1) {
        values[i]=boxHeight/2-1;
        speeds[i]*=-1;
      } else if (values[i]<1-boxHeight/2) {
        values[i]=1-boxHeight/2;
        speeds[i]*=-1;
      }
    }
  }
}
void setup() {
  size(600, 500);
  v = new Visualizer(20, 20, 100, 400, 500);
}
void draw() {
  background(255);
  v.display();
  v.update();
}
