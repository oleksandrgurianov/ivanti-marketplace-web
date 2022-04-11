import httpCommon from "../http-common";

const getApplicationsByCreator = () => {
    return httpCommon.get("/creator/:id")
}

const ApplicationService = {
    getApplicationsByCreator
}

export default ApplicationService;