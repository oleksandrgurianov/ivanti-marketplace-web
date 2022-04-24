import React from 'react'
import { TitleContainer, TitleHeading, Icon, Line } from './TitleStyled'

const Title = ({title, icon}) => {
  return (
    <TitleContainer>
      <TitleHeading>{title}</TitleHeading>
      <hr />
    </TitleContainer>
  )
}

export default Title