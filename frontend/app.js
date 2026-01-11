const API = 'http://localhost:8080/api';

async function apiGet(path) {
  const res = await fetch(`${API}${path}`);
  if (!res.ok) throw new Error(`GET ${path} -> ${res.status}`);
  return res.json();
}

async function apiPost(path, body) {
  const res = await fetch(`${API}${path}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body),
  });
  const text = await res.text();
  if (!res.ok) {
    throw new Error(`POST ${path} -> ${res.status}\n${text}`);
  }
  try { return JSON.parse(text); } catch { return text; }
}

function pretty(obj) {
  return typeof obj === 'string' ? obj : JSON.stringify(obj, null, 2);
}

function bind() {
  const outHealth = document.getElementById('out-health');
  const outMembers = document.getElementById('out-members');
  const outFacilities = document.getElementById('out-facilities');
  const outBookings = document.getElementById('out-bookings');

  document.getElementById('btn-health').addEventListener('click', async () => {
    outHealth.textContent = '...';
    try {
      const data = await apiGet('/health');
      outHealth.textContent = pretty(data);
    } catch (e) {
      outHealth.textContent = String(e);
    }
  });

  document.getElementById('btn-members').addEventListener('click', async () => {
    outMembers.textContent = '...';
    try {
      const data = await apiGet('/members');
      outMembers.textContent = pretty(data);
    } catch (e) {
      outMembers.textContent = String(e);
    }
  });

  document.getElementById('btn-facilities').addEventListener('click', async () => {
    outFacilities.textContent = '...';
    try {
      const data = await apiGet('/facilities');
      outFacilities.textContent = pretty(data);
    } catch (e) {
      outFacilities.textContent = String(e);
    }
  });

  document.getElementById('btn-bookings').addEventListener('click', async () => {
    outBookings.textContent = '...';
    try {
      const data = await apiGet('/bookings');
      outBookings.textContent = pretty(data);
    } catch (e) {
      outBookings.textContent = String(e);
    }
  });

  document.getElementById('form-member').addEventListener('submit', async (ev) => {
    ev.preventDefault();
    const form = ev.currentTarget;
    const body = {
      fullName: form.fullName.value.trim(),
      email: form.email.value.trim(),
    };
    outMembers.textContent = 'Creando socio...';
    try {
      const created = await apiPost('/members', body);
      outMembers.textContent = 'Creado:\n' + pretty(created);
    } catch (e) {
      outMembers.textContent = String(e);
    }
  });

  document.getElementById('form-booking').addEventListener('submit', async (ev) => {
    ev.preventDefault();
    const form = ev.currentTarget;
    const body = {
      memberId: Number(form.memberId.value),
      facilityId: Number(form.facilityId.value),
      date: form.date.value.trim(),
      startTime: form.startTime.value.trim(),
      endTime: form.endTime.value.trim(),
    };
    outBookings.textContent = 'Creando reserva...';
    try {
      const created = await apiPost('/bookings', body);
      outBookings.textContent = 'Creada:\n' + pretty(created);
    } catch (e) {
      outBookings.textContent = String(e);
    }
  });
}

bind();
