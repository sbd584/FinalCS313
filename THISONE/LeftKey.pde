class LeftKey extends MasterKey{
  float x,y;
  PShape lk;
  color c1;
  LeftKey(float x,float y, int _index){
    this.x = x;
    this.y = y;
    this.index = _index;
    fill(300,200,200);
    noStroke();
    lk = createShape(RECT,0,0,50,500);
  }
  public void isClicked(){
    if(mousePressed && mouseX >= this.x && mouseX <= 50+this.x && mouseY >= this.y  && mouseY <= this.y + 500){
      if (this.isClicked == false){
        this.isClicked = true;
        
        keys.get(this.index).trigger();
      }
      else {
        this.isClicked = false;
      }
    }
  }
  public void display(){
    pushMatrix();
    this.isClicked();
    shape(lk,this.x,this.y);
    popMatrix();
  }

}