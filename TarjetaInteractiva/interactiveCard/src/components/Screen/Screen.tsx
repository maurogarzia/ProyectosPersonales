
import { useState } from 'react'
import { Card } from '../ui/Card/Card'
import { CardReverse } from '../ui/CardReverse/CardReverse'
import styles from './Screen.module.css'
import { motion, AnimatePresence } from "framer-motion";

export const Screen = () => {

    const [viewCard, setViewCard] = useState(false) // Estado para mostrar los componentes

    return (
        <div className={styles.containerPrincipal}>
            <button className={styles.spinButton} onClick={() => setViewCard(!viewCard)}>
                <p>Girar</p>
            </button>

            <div>
                <AnimatePresence mode='wait'>
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
                            <Card/>
                        </motion.div>
                    )}
                </AnimatePresence>
            </div>
            
        </div>
    )
}