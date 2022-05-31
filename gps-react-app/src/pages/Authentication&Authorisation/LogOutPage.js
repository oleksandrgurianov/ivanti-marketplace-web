import React from 'react'

function LogOutPage({logout}) {
    const tryLogout = () => {
        logout();
    }
    return (
        <div>
            <button onClick={tryLogout}> logout</button>
        </div>
    )
}

export default LogOutPage;
