import styles from './Card.module.css'
import image6 from '../../images/image6.png'

export const Card = () => {
    return (
        
        <div className={styles.containerPrincipal}>
            <button className={styles.leftArrow}>Flecha</button>
            <div className={styles.containerCard}>
                <div className={styles.blackZone}>
                    <img src={image6} alt="" />
                </div>
                <div className={styles.yellowZone}>
                    <div className={styles.titlePrincipal}>
                        <h2>S.A.N</h2>
                        <h4>Hidráulica</h4> 
                    </div>
                    <div className={styles.containerContact}>
                        <li>Gmail</li>
                        <li>Facebook</li>
                        <li>telefono</li>
                        <li>pagina web</li>
                    </div>
                </div>
            </div>
            <button className={styles.rigthArrow}>
                <span className="material-symbols-outlined">
                    arrow_forward_ios
                </span>
            </button>
        </div>
        
    )
}