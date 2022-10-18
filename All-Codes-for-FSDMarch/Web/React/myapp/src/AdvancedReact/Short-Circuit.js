import React from 'react'

const ShortCircuit = () => {
    let x= "" || "Hello World";
  return (
    <div>{x}</div>
  )
}

export default  ShortCircuit;
