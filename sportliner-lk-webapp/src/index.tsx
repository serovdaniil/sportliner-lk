import App from 'app/App';
import AppRouter from "app/AppRouter";
import {AppRunner} from "app/AppRunner";
import React from 'react';
import {createRoot} from "react-dom/client";

const EMPTY_CONTEXT_PATH = "/";

if (window.location.pathname === EMPTY_CONTEXT_PATH) {
    AppRunner.reset();
}

const container = document.getElementById("root")!;
const root = createRoot(container);

root.render(
    <React.StrictMode>
        <AppRouter>
            <App/>
        </AppRouter>
    </React.StrictMode>
);
