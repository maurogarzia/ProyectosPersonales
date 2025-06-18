
import { useState } from 'react'
import { Card } from '../ui/Card/Card'
import { CardReverse } from '../ui/CardReverse/CardReverse'
import styles from './Screen.module.css'
import { motion, AnimatePresence } from "framer-motion";
import { ModalData } from '../ui/ModalData/ModalData';
import { useStoreModal } from '../useStoreModal';

export const Screen = () => {

    const [viewCard, setViewCard] = useState(false) // Estado para mostrar los componentes
    const {modal, openModal} = useStoreModal()

    // Valores por defecto
    
    return (
        <div className={styles.containerPrincipal}>
            <button className={styles.spinButton} onClick={() => setViewCard(!viewCard)}>
                <p>Girar</p>
            </button>
            <button className={styles.spinButton} onClick={() => openModal()}>
                Cambiar Datos
            </button>

            <div>
                <AnimatePresence mode='wait'>
                    {modal && 
                        <div>
                            <ModalData/>
                        </div>
                    }
                    {viewCard ? (
                        <motion.div
                            key="reverse"
                            initial={{opacity:1 , rotateY: 90}}
                            animate={{opacity: 1, rotateY : 0}}
                            exit={{opacity:1, rotateY: -90}}
                            transition={{duration : 0.2}}
                            style={{perspective : '2000px'}}
                        >
                            <CardReverse/>
                        </motion.div>
                    ): (
                        <motion.div
                            key='front'
                            initial={{opacity : 1, rotateY: 90}}
                            animate ={{opacity : 1, rotateY : 0}}
                            exit={{opacity: 1 , rotateY : -90}}
                            transition={{duration : 0.2}}
                            style={{perspective : '2000px'}}
                        >
                            <Card />
                        </motion.div>
                    )}
                </AnimatePresence>
            </div>
            
        </div>
    )
}