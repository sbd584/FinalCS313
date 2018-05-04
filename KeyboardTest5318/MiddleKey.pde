class MiddleKey extends MasterKey{
  float x,y;
  int choose;
  color c1;
  PShape mk;
  MiddleKey( float x, float y,int index,color c1){
    //this.sample = _sample;
    this.x = x;
    this.y = y;
    this.index = index;
    fill(c1);
    noStroke();
    mk = createShape(GROUP);
    mk.addChild(createShape(RECT,50,0,50,300));
    mk.addChild(createShape(RECT,0,300,100,200));
    choose++;
  }
  public void isClicked(){
    if(mousePressed && (mouseX >= 50+this.x && mouseX <= 100+this.x && mouseY >= this.y  && mouseY <= 750)||mousePressed &&(mouseX >= this.x && mouseX <= 100+this.x && mouseY >= this.y+300 && mouseY <= this.y + 500)){
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
    this.isClicked();
    shape(mk,this.x,this.y);
  }
}