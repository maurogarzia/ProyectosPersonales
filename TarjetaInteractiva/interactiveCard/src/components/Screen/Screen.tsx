
import { useState } from 'react'
import { Card } from '../ui/Card/Card'
import { CardReverse } from '../ui/CardReverse/CardReverse'
import styles from './Screen.module.css'

export const Screen = () => {

    const [viewCard, setViewCard] = useState(false) // Estado para mostrar los componentes

    


    return (
        <div className={styles.containerPrincipal}>
            <button className={styles.leftArrow} onClick={() => setViewCard(false)}>
                <span className="material-symbols-outlined">
                    arrow_back_ios
                </span>
            </button>
            <div>
                {viewCard ? <Card/> : <CardReverse/>}
            </div>
            <button className={styles.rigthArrow} onClick={() => setViewCard(true)}>
                <span className="material-symbols-outlined">
                    arrow_forward_ios
                </span>
            </button>
        </div>
    )
}