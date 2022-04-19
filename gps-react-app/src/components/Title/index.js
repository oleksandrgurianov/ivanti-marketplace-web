// import React from 'react'

// const Title({title}) {
//   return (
//     <div className='title'>
//         <h4>{title}</h4>
//     </div>
//   )
// }

import React from 'react'
import { TitleContainer, TitleHeading } from './TitleStyled'

const Title = ({title}) => {
  return (
    // <div className='title'>
    //   <h4>{title}</h4>
    // </div>
    <TitleContainer>
      <TitleHeading>{title}</TitleHeading>
    </TitleContainer>
  )
}

export default Title