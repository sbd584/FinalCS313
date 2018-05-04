class WhiteKey extends MasterKey{
  float x,y;
  PShape wk;
  WhiteKey(float x,float y,int index){
    this.x = x;
    this.y = y;
    this.index = index;
    fill(255);
    noStroke();
    wk = createShape(RECT,0,0,50,300);
  }

  public void isClicked(){
  if(mousePressed && mouseX >= this.x && mouseX <= 50+this.x && mouseY >= this.y  && mouseY <= this.y + 300){
      if(this.isClicked == false){
        this.isClicked = true;
        keys.get(this.index).trigger();
      }
      else{
        this.isClicked = false;
      }
    }
  }
  public void display(){
    this.isClicked();
    shape(wk,this.x,this.y);
  }

}