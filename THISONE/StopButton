class StopButton {
  float x;
  float y;
  float vel;
  int l = 75;
  float posX =0;
  PShape stopB;
  boolean rectIsShrinking = false;
  
  StopButton(float x, float y) {
    this.x = x;
    this.y = y;
    
    stopB = loadShape("Stop.svg");
  
  }
  
  void spin() {
    vel += 0.2;
  }
  
  void display1() {
    shapeMode(CENTER);
    pushMatrix();
    shape(stopB, this.x, this.y, 75, 75);
    popMatrix();
  }  
  
  void display2() {
    shapeMode(CENTER);
    pushMatrix();
    translate(this.x + posX, this.y);
    rotate(vel);
    shape(stopB, 0, 0, l, l);
    popMatrix();
    if (rectIsShrinking) {
      l--;
      posX--;
    }
    else {
       l++;
       posX++;
    }
    if (l == 50 || l == 100) {
      rectIsShrinking = !rectIsShrinking;
    }
  }
}
