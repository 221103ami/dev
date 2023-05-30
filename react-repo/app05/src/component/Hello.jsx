import { useState } from "react";

export default function Hello(){

    console.log("헬로 함수 호출됨 ...");
    
    const [cnt, setCnt] = useState(0);

    function f01(){
        setCnt(cnt+1);
        console.log(cnt);
    }

    return <h1 onClick={f01}>안녕 {cnt}</h1>
}