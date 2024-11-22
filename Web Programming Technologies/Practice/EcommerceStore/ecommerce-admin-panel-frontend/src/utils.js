import { config } from "./util/config"


export function createUrl(path){

    return `${config.url}/${path}`
}