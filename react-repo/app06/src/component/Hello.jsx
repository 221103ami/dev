import { useEffect, useRef, useState } from "react"
import { useNavigate } from "react-router-dom";

export default function Hello(){
    console.log("헬로 함수 시작");

    const navi = useNavigate();

    function moveUrl(){
        navi("/board/list");
    }

    const [cnt , setCnt] = useState(0);

    function increaseCnt(){
        setCnt(cnt+1);
    }

    useEffect( ()=>{
        const timer = setInterval(() => {
            console.log("3초...");
        }, 3000);

        console.log(x.current);

        return ()=>{
            clearInterval(timer);
        };
    } );

    const x = useRef();
    

    console.log("리턴 직전");
    return <>
        <h1 onClick={moveUrl}>안녕ㅋㅋ</h1>
        <button onClick={increaseCnt}>버튼</button>
        <h2>버튼을 클릭한 횟수 : {cnt}</h2>
        <input type="text" ref={x} />
    </>
}