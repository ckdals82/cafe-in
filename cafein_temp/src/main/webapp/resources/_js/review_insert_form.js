   var count;
   
   function starmark(item){
      
      count=item.id[0];
      sessionStorage.starRating = count;
      
      var subid= item.id.substring(1);
      
      for(var i=0;i<5;i++) {
            if(i<count){
               document.getElementById((i+1)+subid).style.color="orange";
            }else{
               document.getElementById((i+1)+subid).style.color="black";
            }
      }
   
   }

   function send(f){
      //Rating : Count
      //Review : Comment(id)
      /* alert("Rating : "+count+"\nReview : "+document.getElementById("comment").value); */
      
      var name         = f.name.value.trim();
      var date         = f.date.value.trim();
      var cafe_name      = f.cafe_name.value.trim();
      var cafe_location   = f.cafe_location.value.trim();
      var cafe_mood      = f.cafe_mood.value.trim();
      var photo         = f.photo.value;
      
      if(name==''){
         
         swal({title:'',text:'작성자 명을 입력하세요!',icon:'warning',timer:1000});
         f.p_title.value='';
         
         return;
      }
      
      if(date==''){
         
         swal({title:'',text:'방문일자를 입력하세요!',icon:'warning',timer:1000});
         f.p_title.value='';
         
         return;
      }
      
      if(cafe_name==''){
         
         swal({title:'',text:'방문일자를 입력하세요!',icon:'warning',timer:1000});
         f.p_title.value='';
         
         return;
      }
      
      f.action = 'insert.do';   //
      f.submit();
      
   }
   
   function setThumbnail(event) {
      for (var image of event.target.files) { 
         
         var reader = new FileReader(); 
         
         reader.onload = function(event) { 
            var img = document.createElement("img"); 
            img.setAttribute("src", event.target.result); 
            document.querySelector("div#image_container").appendChild(img); 
            }; 
            
            console.log(image); 
            reader.readAsDataURL(image); 
      } 
   }
