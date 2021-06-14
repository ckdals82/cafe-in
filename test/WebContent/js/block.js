
class Block{

	constructor(x,y,w,h,color,show){
		
		this._x = x;
		this._y = y;
		this._w = w;
		this._h = h;
		this._color = color;
		this._show  = show;
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
	
	set w(w){
		this._w = w;
	}
	
	get w(){
		return this._w;
	}
	
	set h(h){
		this._h = h;
	}
	
	get h(){
		return this._h;
	}
	
	set show(show){
		this._show = show;
	}
	
	get show(){
		return this._show;
	}
	
	contains(x,y){
		
		var result = (x>= this._x && x<(this._x + this._w) ) && 
					 (y >= this._y && y <=(this._y + this._h));
				
			return result;	
	}
	
	draw(ctx){

        if(this._show){ 		
			ctx.fillStyle = this._color;
			ctx.fillRect(this._x+1,this._y+1,this._w-2,this._h-2);
			ctx.strokeRect(this._x+1,this._y+1,this._w-2,this._h-2);
		}
	}	
	
}







