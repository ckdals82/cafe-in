/**
 * 
 */

class Ball{
	
	constructor(x,y,r,color,W,H,bRight,bDown){
		this._x = x;
		this._y = y;
		this._r = r;
		this._color = color;	
		
		this._W = W;
		this._H = H;
		this._bRight = bRight;
		this._bDown  = bDown;	
	}
	
	
	set x(x){
		this._x = x;
	}
	
	get x(){
		return this._x;
	}
	
	set y(y){
		this._y = y;
	}
	
	get y(){
		return this._y;
	}
	
	set r(r){
		this._r = r;
	}
	
	get r(){
		return this._r;
	}
	
	set color(color){
		this._color = color;
	}
	
	get color(){
		return this._color;
	}
	
	set bDown(bDown){
      this._bDown = bDown;
   }
   
   get bDown(){
      return this._bDown;
   }
   
   set bRight(bRight){
      this._bRight = bRight;
   }
   
   get bRight(){
      return this._bRight;
   }
	move(){
	    //가로방향	
		if(this._bRight)
		   this._x += 2;
        else
           this._x -= 2;

        //세로방향
        if(this._bDown)
           this._y += 2;
        else
           this._y -= 2;  

         //왼쪽벽
         if( (this._x - this._r) < 0  )            this._bRight=true;
         else if( (this._x + this._r) > this._W )  this._bRight=false;//오른쪽벽
         else if( (this._y - this._r) < 0 )        this._bDown=true;//윗쪽벽
         else if( (this._y + this._r ) > this._H ) this._bDown=false;//아래쪽벽
             
		
	}
	
	draw(ctx){
	   
       ctx.beginPath();
	   var gap = this._r/3;
	   var radgrad = ctx.createRadialGradient(this._x-gap,this._y-gap,0,this._x-gap,this._y-gap,this._r*1.6); 
	   radgrad.addColorStop(0, '#ffffff'); 
	   radgrad.addColorStop(1, this._color); 
	   ctx.fillStyle = radgrad
	   
	   //      x,  y , r   start  end       반시계(true) 
	   ctx.arc(this._x,  this._y,  this._r , 0    , 2*Math.PI , true );
	   ctx.fill();
	}
	
	
	
	
}