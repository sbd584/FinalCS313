class MuteButton {
  float x;
  float y;
  float vel;
  int l = 125;
  PShape unmute;
  PShape muteB;
  boolean rectIsShrinking = false;
  
  MuteButton(float x, float y) {
    this.x = x;
    this.y = y;
    
    unmute = loadShape("Mute.svg");
    muteB = loadShape("Muted.svg");
  
  }
  
  void spin() {
    vel += 0.2;
  }
  
  void display1() {
    shapeMode(CENTER);
    pushMatrix();
    shape(unmute, this.x, this.y, 125, 125);
    popMatrix();
  }  
  
  void display2() {
    shapeMode(CENTER);
    pushMatrix();
    translate(this.x, this.y);
    rotate(vel);
    shape(muteB, 0, 0, l, l);
    popMatrix();
    if (rectIsShrinking) {
      l--;
    }
    else {
       l++;
    }
    if (l == 75 || l == 150) {
      rectIsShrinking = !rectIsShrinking;
    }
  }
}
