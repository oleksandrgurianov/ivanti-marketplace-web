import React from 'react'
import { TitleContainer, TitleHeading } from './TitleStyled'

const Title = ({title}) => {
  return (
    <TitleContainer>
      <TitleHeading>{title}</TitleHeading>
    </TitleContainer>
  )
}

export default Title