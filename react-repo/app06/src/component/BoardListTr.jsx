import { Link } from "react-router-dom";

export default function BoardListTr( {title, writer, hit} ){

    return <>
        <tr>
            <td><Link to="/board/detail/1">{title}</Link></td>
            <td>{writer}</td>
            <td>{hit}</td>
        </tr>
    </>
}