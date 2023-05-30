export default function Hello(){

    let cnt = 0;
    
    function f01(){
        cnt++;
        console.log(cnt);
    }
    
    return <h1 onClick={ f01 }>클릭된 횟수 : {cnt}</h1>
}


