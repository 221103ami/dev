import {BrowserRouter, Route, Routes} from "react-router-dom";
import Hello from "./Hello";
import BoardList from "./BoardList";
import NotFound from "./NotFound";

export default function Main(){
    return <>

        <BrowserRouter>
            <Routes>
                <Route path="/" element={ <Hello /> } />
                <Route path="/board/list" element={ <BoardList /> } />
                <Route path="/*" element={ <NotFound /> } />
            </Routes>
        </BrowserRouter>

    </>;
}