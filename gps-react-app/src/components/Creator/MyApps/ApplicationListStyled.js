import styled from 'styled-components'

export const Section = styled.section`
    padding: 1rem 0;
    text-align: center;
`

export const List = styled.div`
    width: 80vw;
    margin: 0 auto;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(255px, 1fr));
    grid-row-gap: 2rem;
    grid-column-gap: 30px;
`