import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { Home } from "@/pages/home.tsx";
import {World} from "@/pages/world.tsx";
import {NotFound} from "@/pages/not-found.tsx";

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
        <Routes>
            <Route index element={<Home/>}></Route>
            <Route path="/world/:worldId" element={<World/>}></Route>
            <Route path="*" element={<NotFound/>}/>
        </Routes>
    </BrowserRouter>
  </StrictMode>,
)
