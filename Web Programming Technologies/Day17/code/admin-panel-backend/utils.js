function createSuccess(result) {
  return { data: result, status: 'success' }
}

function createError(error) {
  return { error, status: 'error' }
}

function createResult(error, result) {
  if (error) {
    return createError(error)
  } else {
    return createSuccess(result)
  }
}

module.exports = {
  createError,
  createResult,
  createSuccess,
}
