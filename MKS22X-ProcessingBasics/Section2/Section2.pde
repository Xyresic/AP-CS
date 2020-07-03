int levels, fractal;
color bg, fg;
void setup() {
  size(800, 600);
  levels = 0;
  fractal = 0;
}
void gasket(int levels, float v1x, float v1y, float v2x, float v2y, float v3x, float v3y) {
  triangle(v1x, v1y, v2x, v2y, v3x, v3y);
  if (levels>0) {
    triangle((v1x+v2x)/2, (v1y+v2y)/2, (v2x+v3x)/2, (v2y+v3y)/2, (v3x+v1x)/2, (v3y+v1y)/2);
    gasket(levels-1, v1x, v1y, (v1x+v2x)/2, (v1y+v2y)/2, (v3x+v1x)/2, (v3y+v1y)/2);
    gasket(levels-1, v2x, v2y, (v1x+v2x)/2, (v1y+v2y)/2, (v2x+v3x)/2, (v2y+v3y)/2);
    gasket(levels-1, v3x, v3y, (v2x+v3x)/2, (v2y+v3y)/2, (v3x+v1x)/2, (v3y+v1y)/2);
  }
}
void koch(int levels, float v1x, float v1y, float v2x, float v2y) {
  line(v1x, v1y, v2x, v2y);
  if (levels>0) {
    line((2*v1x+v2x)/3, (2*v1y+v2y)/3, (float)((v1x+v2x)/2+Math.sqrt(3)/6*(v1y-v2y)), (float)((v1y+v2y)/2+Math.sqrt(3)/6*(v2x-v1x)));
    line((2*v2x+v1x)/3, (2*v2y+v1y)/3, (float)((v1x+v2x)/2+Math.sqrt(3)/6*(v1y-v2y)), (float)((v1y+v2y)/2+Math.sqrt(3)/6*(v2x-v1x)));
    koch(levels-1, v1x, v1y, (2*v1x+v2x)/3, (2*v1y+v2y)/3);
    koch(levels-1, (2*v1x+v2x)/3, (2*v1y+v2y)/3, (float)((v1x+v2x)/2+Math.sqrt(3)/6*(v1y-v2y)), (float)((v1y+v2y)/2+Math.sqrt(3)/6*(v2x-v1x)));
    koch(levels-1, (float)((v1x+v2x)/2+Math.sqrt(3)/6*(v1y-v2y)), (float)((v1y+v2y)/2+Math.sqrt(3)/6*(v2x-v1x)), (2*v2x+v1x)/3, (2*v2y+v1y)/3);
    koch(levels-1, (2*v2x+v1x)/3, (2*v2y+v1y)/3, v2x, v2y);
  }
}
void koch(int levels, float v1x, float v1y, float v2x, float v2y, float v3x, float v3y) {
  triangle(v1x, v1y, v2x, v2y, v3x, v3y);
  if (levels>0) {
    koch(levels, v1x, v1y, v2x, v2y);
    koch(levels, v2x, v2y, v3x, v3y);
    koch(levels, v3x, v3y, v1x, v1y);
  }
}
void draw() { 
  background(255);  
  fill(0);
  text("Left click to increment levels, right click to decrement levels, press a key to switch fractal.", 20, 20);
  if (fractal==0) {
    text("Sierpinski Triangle", 20, 40);
    fill(255);
    gasket(levels, width/8, 7*height/8, 7*width/8, 7*height/8, width/2, height/8);
  }
  if (fractal==1) {
    text("Koch Snowflake", 20, 40);
    fill(255);
    koch(levels, width/2, height/4, width/4, 3*height/4, 3*width/4, 3*height/4);
  }
}
void mouseClicked() { 
  if (mouseButton == LEFT) {
    levels ++;
  }
  if (mouseButton == RIGHT && levels>0) {
    levels--;
  }
}
void keyPressed() {
  fractal = (fractal+1)%2;
  levels=0;
}
