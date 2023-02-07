//객체 선언

const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", function(){
    //const x = new Object();
    const x = {
        "age" : 20 ,
        height : 183.7 ,
        weight : 43.2 ,
        "smart phone" : "갤럭시A71"
    };
    console.log(x);

    console.log(x.age);
    console.log(x.height);
    console.log(x.weight);

    x.nick = "1dragon";
    x.colors = ["소라색","연분홍","채도가낮은색"];
    
    console.log( x.colors[0] );

    x.hello = function(){
        console.log("hello @@@");
    };

    x.hello();

    x.age = 21;
    console.log(x['age']);

    
    console.log( x["smart phone"] );
});


const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", () => {
    const computer = {
        cpu : "i5" ,
        ram : 16 ,
        os : "window"
    };

    // console.log( computer.cpu );
    // console.log( computer.ram );
    // console.log( computer.os );

    for(let temp in computer){
        console.log(temp + " / " + computer[temp]);
        console.log(`${temp} / ${computer[temp]}`);
    }

});



const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click" , () => {
    const obj = {};

    // 속성 추가
    obj.name = "심원용";
    obj.age = 20;
    obj.hello = () => {alert("안녕");}

    console.log(obj);
    obj.hello();
    
    // 속성 삭제
    delete(obj.hello);

    obj.hello();
});


