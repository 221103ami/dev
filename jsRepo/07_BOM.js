const openBtn = document.querySelector("#openBtn");
openBtn.addEventListener("click" , ()=>{
    
    //window.open();
    //window.open("https://www.naver.com");
    window.open("https://www.naver.com" , "abc");

});

const timeOutTestBtn = document.querySelector("#timeOutTestBtn");
const intervalTestBtn = document.querySelector("#intervalTestBtn");

timeOutTestBtn.addEventListener("click", () => {

    const newWindow = open("https://www.naver.com");

    setTimeout(()=>{
        newWindow.close();
    } , 3000);

    // setTimeout(()=>{
    //     alert("3초 지났음 !!!");
    // } , 3000);

});

intervalTestBtn.addEventListener("click", ()=>{
    setInterval(() => {
        console.log("3초 !!!");
    } , 3000);
});

const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click" , function(){
    console.log( window.location );

    const x = setTimeout(()=>{
        //location.reload();
        location.href = "https://www.naver.com";
    }, 3000);

    //clearTimeout(x);
    
});

const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", function(){
    console.log( navigator );
});

const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click" , function(){
    console.log( screen );
});


