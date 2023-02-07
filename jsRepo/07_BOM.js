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