import { useParams } from "react-router-dom"
import dummy from "../db/data.json";

export default function BoardDetail(){

    const {num} = useParams();
    const voArr = dummy.board.filter( x => x.id === parseInt(num) );
    const vo = voArr[0];

    return <>
        게시글 번호 : {vo.id}
        <br />
        제목 : {vo.title}
        <br />
        내용 : {vo.content}
        <br />
        작성자 : {vo.writer}
        <br />
        조회수 : {vo.hit}
    </>
}