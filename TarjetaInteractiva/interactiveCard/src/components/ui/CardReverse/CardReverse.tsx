import styles from './CardReverse.module.css'
import image6 from '../../../images/image6.png'

import { useStoreData } from '../../useStoreData'

export const CardReverse = () => {

    const {data} = useStoreData()

    return(
        <div className={styles.containerCard}>
            <div className={styles.grayZone}>

            </div>
            <div className={styles.blackZoneWrapper}>
                <div className={styles.blackZone}>
                    
                </div>
                <div className={styles.blackZoneImage}>
                    <img src={data.logo} alt="" />
                    <p>Reparación de sistemas hidráulicos y venta de repuestos</p>
                </div>
            </div>

        </div>
    )
}