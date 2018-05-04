class PlayButton {
  float x;
  float y;
  float vel;
  int l = 75;
  int posX;
  PShape playB;
  boolean rectIsShrinking = false;
  
  PlayButton(float x, float y) {
    this.x = x;
    this.y = y;
    
    playB = loadShape("Play.svg");
  
  }
  
  void spin() {
    vel += 0.2;
  }
  
  void display1() {
    shapeMode(CENTER);
    pushMatrix();
    shape(playB, this.x, this.y, 75, 75);
    popMatrix();
  }  
  
  void display2() {
    shapeMode(CENTER);
    pushMatrix();
    translate(this.x + posX, this.y);
    rotate(vel);
    shape(playB, 0, 0, l, l);
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
