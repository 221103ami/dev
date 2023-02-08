const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", ()=>{
    const tag = document.createElement('h1');
    const text = document.createTextNode("helloWorld");

    tag.appendChild(text);
    console.log(tag);

    const t01 = document.querySelector("#target01");
    t01.appendChild(tag);
});

const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", ()=>{
    const tag = document.createElement("img");
    tag.src = "https://img.gqkorea.co.kr/gq/2022/10/style_634e7c680d723.jpg";
    // tag.width = '300';
    // tag.height = '300';
    tag.setAttribute("width" , '50px');
    tag.setAttribute("height" , '50px');
    tag.setAttribute("atk" , 777);

    

    const t02 = document.querySelector("#target02");
    t02.appendChild(tag);
    
});

const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", function(){

    const arr = document.querySelectorAll("h2");
    const t = arr[arr.length-1];
    t.remove();

});










