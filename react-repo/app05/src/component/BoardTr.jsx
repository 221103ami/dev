import { useState } from "react";

export default function BoardTr({title,writer,hit}){

    const [hitValue , setHit] = useState(hit);

    function f01(){
        setHit(parseInt(hitValue)+1);
    }

    return <>
        <tr onClick={f01}>
            <td>{title}</td>
            <td>{writer}</td>
            <td>{hitValue}</td>
        </tr>
    </>
}