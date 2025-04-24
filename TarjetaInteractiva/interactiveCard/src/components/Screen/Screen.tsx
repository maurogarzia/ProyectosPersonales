
import { Card } from '../ui/Card/Card'
import styles from './Screen.module.css'

export const Screen = () => {

    return (
        <div className={styles.containerPrincipal}>
            <button className={styles.leftArrow}>
                <span className="material-symbols-outlined">
                    arrow_back_ios
                </span>
            </button>
            <div>
                <Card/>
            </div>
            <button className={styles.rigthArrow}>
                <span className="material-symbols-outlined">
                    arrow_forward_ios
                </span>
            </button>
        </div>
    )
}